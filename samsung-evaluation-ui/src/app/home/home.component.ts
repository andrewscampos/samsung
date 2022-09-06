import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, NgForm, FormBuilder} from '@angular/forms';
import {Currency} from '../model/Currency'
import {Filter} from '../model/Filter'
import {Document} from '../model/Document'
import { HttpService } from '../services/http.service';





@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  displayedColumns: string[] = ['documentNumber', 'documentDate', 'currencyCode', 'currencyDesc','documentValue', 'valueUSD','valuePEN', 'valueBRL'];
  currencys: Currency[] = []
  dataSource: Document[] = [];
  formGroup: FormGroup;

  constructor(private httpService: HttpService, private fb: FormBuilder) {

    this.formGroup = fb.group({
      docNumber: [''], 
      firstDate: [''], 
      secondDate: [''], 
      currencyCode: [''], 
    });
   }

  ngOnInit(): void {
    this.httpService.currencys().subscribe(res => {
      this.currencys = res
    });
    this.loadDataSource()
  }

  loadDataSource() : void{
    const filter: Filter = new Filter();
    filter.startDate = this.formGroup.value?.firstDate;
    filter.endDate = this.formGroup.value?.secondDate;
    filter.currencyCode = this.formGroup.value?.currencyCode;
    filter.docNumber = this.formGroup.value?.docNumber;
    this.httpService.docs(filter).subscribe(res => {
      this.dataSource = res
    });
  }

  clear(): void{
    this.formGroup = this.fb.group({
      docNumber: [''], 
      firstDate: [''], 
      secondDate: [''], 
      currencyCode: [''], 
    });
  }
  
}
