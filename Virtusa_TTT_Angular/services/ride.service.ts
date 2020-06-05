import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Ride} from 'src/app/models/ride-model';
import {Observable} from 'rxjs';
import {Subject} from 'rxjs';
import{Customer} from 'src/app/models/customer-model'
import { PaymentDetails } from '../models/paymentdetails-model';
@Injectable({
  providedIn: 'root'
})
export class RideService {

  constructor(private http:HttpClient) { }
  formData: Ride;
  readonly APIUrl="http://localhost:8280/api";
  getRdList(): Observable<Ride[]> {
    return this.http.get<Ride[]>(this.APIUrl + '/ride');
  }
  addRide(dep:Ride){
    return this.http.post(this.APIUrl+'/ride', dep)
  }
  deleteRide(id: number){
    return this.http.delete(this.APIUrl+'/ride/'+id);
  }
  getDepDropDownValues():Observable<any>{
    return this.http.get<Customer[]>(this.APIUrl+'/customer');
  }

  payRide(dep:PaymentDetails) {
    
    let params = new HttpParams();
    params = params.append('rideId', dep.ride_id);
    params = params.append('coustomerId', dep.customer_id);
    return this.http.get(this.APIUrl+'/payRide', {params:params});
  }
  saveRider(dep:PaymentDetails) {
    
    let params = new HttpParams();
    params = params.append('rideId', dep.ride_id);
    params = params.append('coustomerId', dep.customer_id);
    return this.http.get(this.APIUrl+'/saveRider', {params:params});
  }
  updateRide(dep:Ride) {
    return this.http.put(this.APIUrl+'/ride',dep);
  }


  filter(filterBy: string){
    this._listners.next(filterBy);
  }
  private _listners = new Subject<any>();
  listen(): Observable<any>{
    return this._listners.asObservable();
  }

}
