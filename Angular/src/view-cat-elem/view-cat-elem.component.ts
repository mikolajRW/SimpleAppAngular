import { Component, OnInit } from '@angular/core';
import { DriverService } from '../app/services/driverService';
import { CarService } from '../app/services/carService';
import { CommonModule } from '@angular/common';
import { CarsForDriverPipe } from './CarsForDPipe';
import { ActivatedRoute, Router, RouterLink, RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-view-cat-elem',
  imports: [CommonModule, CarsForDriverPipe, RouterLink, RouterModule],
  templateUrl: './view-cat-elem.component.html',
  styleUrl: './view-cat-elem.component.css'
})
export class ViewCatElemComponent implements OnInit  {
    drivers: any | undefined;
    cars: any | undefined;
    
      constructor(private driverService: DriverService, protected carService: CarService) { }
      ngOnInit(): void {
        this.fetchData();
      }
    
      fetchData(): void {
        this.driverService.getDrivers().subscribe(data=>this.drivers=data);
      }

      onDelete(id:string|undefined): void{
        this.carService.deleteCar(id).subscribe();
      }

      refresh() {
        window.location.reload();
     }

    
      
}
