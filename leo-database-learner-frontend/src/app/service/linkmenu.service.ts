import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LinkmenuService {
  public linkmenu : Boolean[] = [false, true, true, true]

  getMenu() : Boolean[]{
    return this.linkmenu;
  }

  setMenu(home : Boolean, about : Boolean, imp : Boolean, profile : Boolean){
    this.linkmenu[0] = home;
    this.linkmenu[1] = about;
    this.linkmenu[2] = imp;
    this.linkmenu[3] = profile;
  }

}
