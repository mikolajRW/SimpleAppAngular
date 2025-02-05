import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DriverService } from '../app/services/driverService';
@Component({
  selector: 'app-edit-cat',
  imports: [CommonModule],
  templateUrl: './edit-cat.component.html',
  styleUrl: './edit-cat.component.css'
})
export class EditCatComponent implements OnInit  {
    drivers: any | undefined;
    id: string | undefined;
    driver: any | undefined;

    saveId(id :string): void{
      this.id = id
    }
    
    constructor(private driverService: DriverService) { }
    ngOnInit(): void {
      this.fetchData()
    }
    
    fetchData(): void {
      this.driverService.getDrivers().subscribe(data=>this.drivers=data)
    }

    onUpdate(dname: string, dsurname: string, dpesel: string, dage: string): void{
      this.driver = JSON.stringify({
        pesel: dpesel,
        name: dname,
        surname: dsurname,
        age: Number(dage)
      });
      this.driverService.updateDriver(this.id, this.driver).subscribe()
    }

      

}
