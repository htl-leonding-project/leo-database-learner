import { Component, OnInit } from '@angular/core';
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-exams',
  templateUrl: './exams.component.html',
  styleUrls: ['./exams.component.css']
})
export class ExamsComponent implements OnInit {

  constructor(public linkmenu : LinkmenuService) {
    linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
  }

}
