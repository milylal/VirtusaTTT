import { Component, OnInit,ViewChild  } from '@angular/core';
import {MatTableDataSource,MatSort} from '@angular/material';
import {MatSnackBar} from '@angular/material';
import { CustomerService } from 'src/app/services/customer.service';
import {MatDialog,MatDialogConfig} from '@angular/material';
import {AddCustomerComponent} from 'src/app/customer/add-customer/add-customer.component';
import {Customer} from 'src/app/models/customer-model';
import {EditCustomerComponent} from 'src/app/customer/edit-customer/edit-customer.component'
@Component({
  selector: 'app-show-customer',
  templateUrl: './show-customer.component.html',
  styleUrls: ['./show-customer.component.css']
})
export class ShowCustomerComponent implements OnInit {

  constructor(private service:CustomerService,
    private dialog:MatDialog,
    private snackBar:MatSnackBar) { 
      this.service.listen().subscribe((m:any)=>{
        console.log(m);
        this.refreshCustList();
      })
    }
  listData : MatTableDataSource<any>;
  displayedColumns :string[]=['options','id','email','first_name','last_name','password']
  @ViewChild(MatSort, null) sort: MatSort;
  ngOnInit() {
    this.refreshCustList();
  }
  refreshCustList(){
    //var dummyData=[{id:1,rdate:"10-01-20",rtime:"11.00",start_loc:"mumbai",end_loc:"pune",vacancy:3,base_fare:2000}]
    //this.listData=new MatTableDataSource(dummyData);
      this.service.getCustList().subscribe(data =>{
      this.listData =new MatTableDataSource(data);
      this.listData.sort=this.sort;
    });
  }
  applyFilter(filtervalue:  string){
    this.listData.filter= filtervalue.trim().toLocaleLowerCase();
  }
  onAdd(){
    const dialogConfig = new MatDialogConfig();
    dialogConfig.disableClose = true;
    dialogConfig.autoFocus= true;
    dialogConfig.width= "70%";
    this.dialog.open(AddCustomerComponent, dialogConfig);
    
      }
      onEdit(emp: Customer){
        this.service.formData = emp;
        const dialogConfig = new MatDialogConfig();
        dialogConfig.disableClose = true;
        dialogConfig.autoFocus= true;
        dialogConfig.width= "70%";
        this.dialog.open(EditCustomerComponent, dialogConfig);
      }
      onDelete(id:number){
        if(confirm('Are you sure to delete??')){
          this.service.deleteCustomer(id).subscribe(res=>{
            this.refreshCustList();
            this.snackBar.open(res.toString(), '', {
              duration:5000,
              verticalPosition:'top'
            });
          });
        }
      }
    
    
}
