import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { RideService } from 'src/app/services/ride.service';
@Component({
  selector: 'app-select-ride',
  templateUrl: './select-ride.component.html',
  styleUrls: ['./select-ride.component.css']
})
export class SelectRideComponent implements OnInit {

  constructor(private service:RideService,
    public dialogbox: MatDialogRef<SelectRideComponent>,
    private snackBar:MatSnackBar) { }
    public listItems: Array<string> = [];


  ngOnInit() {
    this.resetForm();
    this.dropdownRefresh();

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
  dropdownRefresh(){
    this.service.getDepDropDownValues().subscribe(data=>{
      console.log(data);
      data.forEach(element => {
        
        this.listItems.push(element["id"])
      });
    })
            }
    
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }
  onSubmit(form:NgForm){
    this.service.saveRider(form.value).subscribe(res=>{
      this.snackBar.open(res.toString(),'',{
        duration:5000,
        verticalPosition:'top'

      })
    })
  }
}
