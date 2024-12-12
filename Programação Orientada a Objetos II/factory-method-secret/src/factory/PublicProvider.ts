import * as fs from 'fs';

export class PublicProvider {
    private password = 'designpatterns';
    private file = 'public.txt';

    public acessFile(): void {
        const data = fs.readFileSync(this.file, 'utf8');
        console.log(data);
    }
}