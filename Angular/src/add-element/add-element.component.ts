import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DriverService } from '../app/services/driverService';
import { CarService } from '../app/services/carService';
import { ActivatedRoute, Router,RouterLink } from '@angular/router';

@Component({
  selector: 'app-add-element',
  imports: [CommonModule, RouterLink],
  templateUrl: './add-element.component.html',
  styleUrl: './add-element.component.css'
})
export class AddElementComponent implements OnInit  {
    drivers: any | undefined;
    car: any | undefined;
    driver:any | undefined;

    
    constructor(private driverService: DriverService, private carService: CarService,
      private route: ActivatedRoute, private router:Router
    ) { }
    ngOnInit(): void {
      this.fetchData();
      const id_ = this.route.snapshot.paramMap.get("driverId")
      if(id_){
        this.driverService.getDriverId(id_).subscribe(data=>this.driver=data);
    }
    }
    
    fetchData(): void {
      this.driverService.getDrivers().subscribe(data=>this.drivers=data)
    }

    add(cvin:string, cbrand:string, cmodel:string):void{
      console.log(cvin, cbrand, cmodel);
      this.car = JSON.stringify({
        vin: cvin,
        brand: cbrand,
        model: cmodel
      })
      this.carService.addCarToDriver(this.driver.driverId, this.car).subscribe();
    }

}
