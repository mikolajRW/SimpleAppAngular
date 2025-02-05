import { Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarService } from '../app/services/carService';
import { ActivatedRoute, Router,RouterLink } from '@angular/router';

@Component({
  selector: 'app-edit-element',
  imports: [CommonModule, RouterLink],
  templateUrl: './edit-element.component.html',
  styleUrl: './edit-element.component.css'
})
export class EditElementComponent implements OnInit {
  cars : any | undefined;
  car:any|undefined;
  car_:any|undefined;
  

  constructor(private carService: CarService, private route: ActivatedRoute, private router:Router){};
  ngOnInit(): void {
    this.fetchData();
    const id_ = this.route.snapshot.paramMap.get("id")
    if(id_){
      this.carService.getCarsbyId(id_).subscribe(data=>this.car_=data);
    }
  
  }
  
  
  fetchData(): void{
    this.carService.getCars().subscribe(data=>this.cars=data);
  }

  

  onUpdate(cvin: string, cbrand: string, cmodel: string): void{
    this.car = JSON.stringify({
      vin: cvin,
      brand: cbrand,
      model: cmodel
    })
    this.carService.updateCar(this.car_.id, this.car).subscribe()
  }

}
