import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
    providedIn: 'root',
})

export class CarService {
    private carsUrl = 'http://localhost:8083/api';
    httpOptions = {
        headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    constructor(
        private http: HttpClient) { };
    
    getCars(){
        return this.http.get<any>(`${this.carsUrl}/cars`).pipe(catchError(this.handleError('getCars',[])));
    }

    getCarsofDriver(id: string|undefined){
        return this.http.get<any>(`${this.carsUrl}/drivers/${id}/cars`).pipe(catchError(this.handleError('getCarsofDriver',[])));
    }

    addCarToDriver(id:any, car: any){
        return this.http.post<any>(`${this.carsUrl}/drivers/${id}/cars`,car, this.httpOptions).pipe(catchError(this.handleError('addCarToDriver',[])));
    }

    updateCar(id:string|undefined, car:any){
        return this.http.put<any>(`${this.carsUrl}/cars/${id}`, car, this.httpOptions).pipe(catchError(this.handleError('updateCar',[])));
    }

    deleteCar(id:string|undefined){
        return this.http.delete<any>(`${this.carsUrl}/cars/${id}`, this.httpOptions).pipe(catchError(this.handleError('deleteCar',[])));
    }

    getCarsbyId(id:any){
        return this.http.get<any>(`${this.carsUrl}/cars/${id}`, this.httpOptions)
    }

    

    private handleError<T>(operation = 'operation', result?: T) {
        return (error: any): Observable<T> => {
            console.error(`${operation} failed: ${error.message}`); 
            return throwError(() => new Error(error.message)); 
        };
    }
}