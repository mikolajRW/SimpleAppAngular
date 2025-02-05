import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CarService } from '../app/services/carService';

@Component({
  selector: 'app-element-details',
  imports: [CommonModule],
  templateUrl: './element-details.component.html',
  styleUrl: './element-details.component.css'
})
export class ElementDetailsComponent implements OnInit {
  cars:any|undefined;

  constructor(private carService: CarService ){}
  ngOnInit(): void {
    this.fetchData();
  }

  fetchData(){
    this.carService.getCars().subscribe(data=>this.cars=data);
  }
}
