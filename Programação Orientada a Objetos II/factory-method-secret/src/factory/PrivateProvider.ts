import * as fs from 'fs';

export class PrivateProvider {

    private password = 'designpatterns';
    private file = 'confidential.txt';

    public acessFile(password: string): void {
        if (password === this.password) {
            const data = fs.readFileSync(this.file, 'utf8');
            console.log(data);
        } else {
            console.log('Wrong password');
        }
    }
}