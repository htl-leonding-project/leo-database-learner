import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { DialogData } from '../task-detail/task-detail.component';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  public header : String[];
  public tabledata : String[][] = [];
  public error : Boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: DialogData) { }

  ngOnInit(): void {
    if(this.data.result[0] != "ERROR"){
      this.header = this.data.result[0].split(" ");

      for (let index = 1; index < this.data.result.length; index++) {
        var store : String[] = this.data.result[index].split(" ");
        this.tabledata[index-1] = [];
        for (let index2 = 0; index2 < this.header.length-1; index2++) {
          //alert("R:" + (index -1) + " / C: " + index2 + ": " + store[index2]);
          this.tabledata[(index - 1)][index2] = store[index2];
        }
      }
    }else{
      this.error = true;
    }
  }

}
