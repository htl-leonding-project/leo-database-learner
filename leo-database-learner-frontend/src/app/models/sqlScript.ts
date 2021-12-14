import {Datamodel} from "./datamodel";

export class SqlScript {
  createScript: string;
  dropScript: string;
  insertScript: string;
  dataModel: Datamodel;


  constructor(createScript: string, dropScript: string, insertScript: string, dataModel: Datamodel) {
    this.createScript = createScript;
    this.dropScript = dropScript;
    this.insertScript = insertScript;
    this.dataModel = dataModel;
  }
}
