import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { RideService } from 'src/app/services/ride.service';
import {MatDialog,MatDialogConfig} from '@angular/material';

@Component({
  selector: 'app-pay-ride',
  templateUrl: './pay-ride.component.html',
  styleUrls: ['./pay-ride.component.css']
})
export class PayRideComponent implements OnInit {

  constructor(private service:RideService,
    public dialogbox: MatDialogRef<PayRideComponent>,
    private snackBar:MatSnackBar) { 
    }
  displayedColumns :string[]=['id','customer_id','ride_id']

  ngOnInit() {
  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  onSubmit(form:NgForm){
    this.service.payRide(form.value).subscribe(res=>{
      this.snackBar.open(res.toString(),'',{
        duration:5000,
        verticalPosition:'top'

      })
    })
  }
}
