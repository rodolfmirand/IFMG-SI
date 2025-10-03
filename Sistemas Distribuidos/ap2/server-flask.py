#!/usr/bin/env python
# encoding: utf-8
import os
from flask import Flask, request, jsonify, render_template
from pymongo import MongoClient
from pymongo.server_api import ServerApi
from dotenv import load_dotenv

load_dotenv()

MONGO_URI = os.getenv("MONGO_URI")

client = MongoClient(MONGO_URI, server_api=ServerApi('1'))
db = client["ap2-database"]
collection = db["pessoas"]

app = Flask(__name__)

@app.route('/ui')
def ui():
    return render_template('index.html')

@app.route("/get", methods=["GET"])
def get_records():
    records = list(collection.find({}, {"_id": 0}))
    return jsonify(records)

@app.route("/", methods=["POST"])
def create_record():
    record = request.get_json()
    collection.insert_one(record)
    return "", 201

@app.route("/update", methods=["PUT"])
def update_record():
    data = request.json
    old_name = data.get("old_name")
    new_name = data.get("new_name")
    new_email = data.get("new_email")

    result = collection.update_one(
        {"name": old_name},
        {"$set": {"name": new_name, "email": new_email}}
    )

    if result.modified_count:
        return jsonify({"success": True})
    return jsonify({"error": "not found"}), 404

# Excluir usuário
@app.route("/delete", methods=["DELETE"])
def delete_record():
    data = request.json
    name = data.get("name")
    result = collection.delete_one({"name": name})

    if result.deleted_count:
        return jsonify({"success": True})
    return jsonify({"error": "not found"}), 404

if __name__ == "__main__":
    app.run(debug=True)