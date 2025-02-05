import { Component, OnInit } from '@angular/core';
import { DriverService } from '../app/services/driverService';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-viewcat',
  imports: [CommonModule],
  templateUrl: './viewcat.component.html',
  styleUrl: './viewcat.component.css'
})
export class ViewcatComponent implements OnInit  {
    drivers: any | undefined;
    
      constructor(private driverService: DriverService) { }
      ngOnInit(): void {
        this.fetchData()
      }
    
      fetchData(): void {
        this.driverService.getDrivers().subscribe(data=>this.drivers=data)
      }
      onDelete(driver:any):void{
        this.driverService.deleteDriver(driver.driverId).subscribe();
      }
    
      refresh() {
        window.location.reload();
     }
}
