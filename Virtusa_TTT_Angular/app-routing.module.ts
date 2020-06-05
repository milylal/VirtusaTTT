import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerComponent } from './customer/customer.component';
import { RideComponent } from './ride/ride.component';
import { SelectRideComponent } from './ride/select-ride/select-ride.component';


const routes: Routes = [
  { path:'customer',component:CustomerComponent},
  { path:'ride',component:RideComponent},
  { path:'selectride',component:SelectRideComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
