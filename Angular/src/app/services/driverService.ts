import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root',
})


export class DriverService {
  private driversUrl = 'http://localhost:8083/api';
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient) { }
  
  getDrivers(){
    return this.http.get<any>(`${this.driversUrl}/drivers`).pipe(catchError(this.handleError('getDrivers',[])));
    /*return fetch(`${this.driversUrl}/drivers`).then(response=>{
      if(response.ok){
        return response.json();
      }
      throw new Error("Network error");
    })*/
  }

  deleteDriver(id: string){
    return this.http.delete<any>(`${this.driversUrl}/drivers/${id}`, this.httpOptions).pipe(catchError(this.handleError('deleteDriver',[])));
  }

  addDriver(driver: any){
    return this.http.post<any>(`${this.driversUrl}/drivers`, driver,this.httpOptions ).pipe(catchError(this.handleError('addDriver')))
  }

  updateDriver(driverId: string|undefined, driver: any){
    return this.http.put(`${this.driversUrl}/drivers/${driverId}`, driver, this.httpOptions).pipe(catchError(this.handleError('updateDriver')))
  }

  getDriverId(id:any){
    return this.http.get<any>(`${this.driversUrl}/drivers/${id}`, this.httpOptions)
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`); 
      return throwError(() => new Error(error.message));
    };


 }}


