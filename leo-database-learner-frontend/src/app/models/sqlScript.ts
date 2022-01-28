import { DataModel } from "./datamodel";


export class SqlScript {
  createScript: string;
  dropScript: string;
  insertScript: string;
  dataModel: DataModel;


  constructor(createScript: string, dropScript: string, insertScript: string, dataModel: DataModel) {
    this.createScript = createScript;
    this.dropScript = dropScript;
    this.insertScript = insertScript;
    this.dataModel = dataModel;
  }
}
