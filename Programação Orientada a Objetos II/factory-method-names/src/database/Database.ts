export interface Database {
    save(firstname: string, surname: string): void;
    getAll(): string[];
}