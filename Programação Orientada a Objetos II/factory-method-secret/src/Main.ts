import { PrivateProvider } from "./factory/PrivateProvider";
import { PublicProvider } from "./factory/PublicProvider";

let publicProvider = new PublicProvider();
let privateProvider = new PrivateProvider();

publicProvider.acessFile();
privateProvider.acessFile('designpatterns');