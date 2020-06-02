import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import {MatDialogRef} from '@angular/material';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {

  constructor(public dialogbox: MatDialogRef<AddCustomerComponent>,private service:CustomerService,
    private snackBar:MatSnackBar) { }

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
      first_name:'',
      last_name:'',
      email:'',
      password:''
    }
  }
  onSubmit(form:NgForm){
    
    this.service.addCustomer(form.value).subscribe(res=>
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
