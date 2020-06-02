import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { RideService } from 'src/app/services/ride.service';
@Component({
  selector: 'app-edit-ride',
  templateUrl: './edit-ride.component.html',
  styleUrls: ['./edit-ride.component.css']
})
export class EditRideComponent implements OnInit {

  constructor(public dialogbox: MatDialogRef<EditRideComponent>,
    private service:RideService,
    private snackBar:MatSnackBar) { }

  ngOnInit() {
  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  onSubmit(form:NgForm){
    this.service.updateRide(form.value).subscribe(res=>{
      this.snackBar.open(res.toString(),'',{
        duration:5000,
        verticalPosition:'top'

      })
    })
  }

}
