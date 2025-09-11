import { GodClass } from './god.class';
import { UtilityClass } from './utility.class';
import { Executor } from './executor.class';

const god = new GodClass();
const util = new UtilityClass();
const exec = new Executor();

exec.run([god, util]);
