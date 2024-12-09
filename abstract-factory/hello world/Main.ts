import { WriteConsole } from "./WriteConsole"
import { WriteTxt } from "./WriteTxt"

class PrintHelloWorld {

    print(): void {
        const writeTxt = new WriteTxt()
        const writeConsole = new WriteConsole()

        const text = "Hello World!"

        if ((Math.floor(Math.random() * 10) + 1) % 2 === 0) {
            writeTxt.write(text)
        } else {
            writeConsole.write(text)
        }
    }
}

const printer = new PrintHelloWorld()
printer.print()