import { WriteHelloWorld } from "./WriteHelloWorld"
import { writeFile } from 'fs'

export class WriteTxt implements WriteHelloWorld {

    write(text: string): void {
        const path = "D:/Perfil/rodolfo.miranda/Desktop/Rodolfo/IFMG-SI/abstract-factory/hello-world.txt"

        writeFile(path, text, (err) => {
            if(err){
                console.error('Erro', err)
            }
        }) 
    }
}