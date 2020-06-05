import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {MatInputModule} from '@angular/material/input';
import {MatSortModule,MatFormFieldModule} from '@angular/material';
import {MatDialogModule} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {MatTableModule,MatIconModule,MatButtonModule} from '@angular/material';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { CustomerComponent } from './customer/customer.component';
import { ShowCustomerComponent } from './customer/show-customer/show-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { AddCustomerComponent } from './customer/add-customer/add-customer.component';
import { RideComponent } from './ride/ride.component';
import { EditRideComponent } from './ride/edit-ride/edit-ride.component';
import { ShowRideComponent } from './ride/show-ride/show-ride.component';
import { AddRideComponent } from './ride/add-ride/add-ride.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CustomerService} from 'src/app/services/customer.service';
import {RideService} from 'src/app/services/ride.service';
import { SelectRideComponent } from './ride/select-ride/select-ride.component';
import { PayRideComponent } from './ride/pay-ride/pay-ride.component';
@NgModule({
  declarations: [
    AppComponent,
    CustomerComponent,
    ShowCustomerComponent,
    EditCustomerComponent,
    AddCustomerComponent,
    RideComponent,
    EditRideComponent,
    ShowRideComponent,
    AddRideComponent,
    SelectRideComponent,
    PayRideComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatTableModule,MatIconModule,MatButtonModule,
    HttpClientModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    FormsModule,
    MatSnackBarModule
  ],
  providers: [
    CustomerService,
    RideService],
  bootstrap: [AppComponent],
  entryComponents:[AddRideComponent,AddCustomerComponent,EditCustomerComponent,EditRideComponent,PayRideComponent,SelectRideComponent ]
})
export class AppModule { }
