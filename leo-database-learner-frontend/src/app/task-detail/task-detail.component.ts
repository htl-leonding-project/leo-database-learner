import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {

  id = '';

  constructor(
    private route: ActivatedRoute
  ) {  }

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id') || '';

    // this.route.paramMap.subscribe(params => {
    //   console.log(params.get('id'));
    //   this.id = params.get('id');
    // });
  }
  click(): void {
    alert('Data successfully sent');
  }
}
