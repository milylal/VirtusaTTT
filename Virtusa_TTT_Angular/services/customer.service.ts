import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Customer} from 'src/app/models/customer-model';
import {Observable} from 'rxjs';
import {Subject} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor(private http:HttpClient) { }
  formData: Customer;
  readonly APIUrl="http://localhost:8280/api";
  getCustList(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.APIUrl + '/customer');
  }
  addCustomer(dep:Customer){
    return this.http.post(this.APIUrl+'/customer', dep)
  }
  filter(filterBy: string){
    this._listners.next(filterBy);
  }
  private _listners = new Subject<any>();
  listen(): Observable<any>{
    return this._listners.asObservable();
  }
  updateCustomer(dep:Customer) {
    return this.http.put(this.APIUrl+'/customer',dep);
  }
  deleteCustomer(id: number){
    return this.http.delete(this.APIUrl+'/customer/'+id);
  }


}
