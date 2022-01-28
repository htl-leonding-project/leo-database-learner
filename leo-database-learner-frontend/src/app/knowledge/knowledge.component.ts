import { Component, OnInit } from '@angular/core';
import { LinkmenuService } from '../service/linkmenu.service';

@Component({
  selector: 'app-knowledge',
  templateUrl: './knowledge.component.html',
  styleUrls: ['./knowledge.component.css']
})
export class KnowledgeComponent implements OnInit {

  constructor(public linkmenu : LinkmenuService) {
    linkmenu.setMenu(true, true, true, true);
  }

  ngOnInit(): void {
  }

}
