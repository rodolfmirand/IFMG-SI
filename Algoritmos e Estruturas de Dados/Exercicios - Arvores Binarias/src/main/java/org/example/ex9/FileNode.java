package org.example.ex9;

public class FileNode<T> implements Comparable<FileNode<T>> {

    private String name;
    private T lastAccessDate;
    private FileNode<T> leftNode;
    private FileNode<T> rightNode;
    private FileNode<T> parent;

    public FileNode(T lastAccessDate, String name) {
        this.lastAccessDate = lastAccessDate;
        this.name = name;
        this.leftNode = this.rightNode = this.parent = null;
    }

    public T getLastAccessDate() {
        return lastAccessDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileNode<T> getLeftNode() {
        return this.leftNode;
    }

    public void setLeftNode(FileNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public FileNode<T> getRightNode() {
        return this.rightNode;
    }

    public FileNode<T> getParent() {
        return this.parent;
    }

    public void setParent(FileNode<T> parent) {
        this.parent = parent;
    }

    public void setRightNode(FileNode<T> rightNode) {
        this.rightNode = rightNode;
    }

    public void setLastAccessDate(T lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    @Override
    public String toString() {
        return "BinNode{" +
                "data=" + lastAccessDate +
                '}';
    }

    @Override
    public int compareTo(FileNode<T> o) {
        return 0;
    }
}
