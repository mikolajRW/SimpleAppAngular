import { Pipe, PipeTransform } from '@angular/core';
import { CarService } from '../app/services/carService';
import { Observable } from 'rxjs';

@Pipe({
  name: 'carsForDriver'
})
export class CarsForDriverPipe implements PipeTransform {
  transform(driverId: string | undefined, carsService: CarService): Observable<any[]> {
    return carsService.getCarsofDriver(driverId); 
  }
}
