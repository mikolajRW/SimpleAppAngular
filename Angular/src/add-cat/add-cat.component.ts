import { Component } from '@angular/core';
import { DriverService } from '../app/services/driverService';
import { pseudoRandomBytes } from 'crypto';
@Component({
  selector: 'app-add-cat',
  imports: [],
  templateUrl: './add-cat.component.html',
  styleUrl: './add-cat.component.css'
})
export class AddCatComponent {
  
  driver:any|undefined;
  constructor(private driverService: DriverService) { };
  add(dname: string, dsurname: string, dpesel: string, dage: string){
    this.driver = JSON.stringify({
      pesel: dpesel,
      name: dname,
      surname: dsurname,
      age: Number(dage)
    });
    this.driverService.addDriver(this.driver).subscribe();
  }
}
