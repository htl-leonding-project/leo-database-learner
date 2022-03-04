import {DataModel} from "./datamodel";

export class ExercisePackage {
  name: string;
  dataModel: DataModel;
  id: Number;

  constructor(name: string, dataModel: DataModel, id: Number = 0) {
    this.name = name;
    this.dataModel = dataModel;
  }
}
