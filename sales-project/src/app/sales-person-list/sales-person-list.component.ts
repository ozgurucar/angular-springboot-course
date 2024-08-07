import { Component } from '@angular/core';
import { SalesPerson } from './sales-person';



@Component({
  selector: 'app-sales-person-list',
  standalone: true,
  imports: [],
  templateUrl: './sales-person-list.component.html',
  styleUrl: './sales-person-list.component.css'
})
export class SalesPersonListComponent { 
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Ozgur", "Ucar", "ozgurucar@deneme.com", 90000),
    new SalesPerson("Test", "Eder", "testeder@deneme.com", 50000),

  ]
}
