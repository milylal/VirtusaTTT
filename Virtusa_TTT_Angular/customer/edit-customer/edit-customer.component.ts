import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from '@angular/material';
import { NgForm } from '@angular/forms';
import {MatSnackBar} from '@angular/material';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  constructor(public dialogbox: MatDialogRef<EditCustomerComponent>,
    private service:CustomerService,
    private snackBar:MatSnackBar) { }

  ngOnInit() {

  }
  onClose(){
    this.dialogbox.close();
    this.service.filter('Register click');
  }

  onSubmit(form:NgForm){
    this.service.updateCustomer(form.value).subscribe(res=>{
      this.snackBar.open(res.toString(),'',{
        duration:5000,
        verticalPosition:'top'

      })
    })
  }

}
