import {DataModel} from "./datamodel";

export class ExercisePackage {
  name: string;
  dataModel: DataModel;


  constructor(name: string, dataModel: DataModel) {
    this.name = name;
    this.dataModel = dataModel;
  }
}
