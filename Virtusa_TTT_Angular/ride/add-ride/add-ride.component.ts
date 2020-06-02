import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { RideService } from 'src/app/services/ride.service';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-add-ride',
  templateUrl: './add-ride.component.html',
  styleUrls: ['./add-ride.component.css']
})
export class AddRideComponent implements OnInit {

  constructor(public dialogbox: MatDialogRef<AddRideComponent>,
    private service:RideService,private snackBar:MatSnackBar) { }

  ngOnInit() {
    this.resetForm();
  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  resetForm(form?:NgForm){
    if(form!=null)
    form.resetForm();

    this.service.formData = {
      id:0,
      rdate:'',
      rtime:'',
      start_loc:'',
      end_loc:'',
      vacancy:0,
      base_fare:0
    }
  }

  onSubmit(form:NgForm){
    
    this.service.addRide(form.value).subscribe(res=>
      {
        this.resetForm(form);
        this.snackBar.open(res.toString(), '', {
          duration:5000,
          verticalPosition:'top'
        });
      }
      )
  }

}
