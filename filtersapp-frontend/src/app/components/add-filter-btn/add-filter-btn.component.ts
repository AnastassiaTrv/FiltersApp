import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-add-filter-btn',
  templateUrl: './add-filter-btn.component.html',
  styleUrls: ['./add-filter-btn.component.css']
})
export class AddFilterBtnComponent implements OnInit {

  @Input() disabled: boolean;
  @Output() onAddBtnClick = new EventEmitter<boolean>();

  openAsModal = false;

  constructor() { }

  ngOnInit() {
  }

  emitAddBtnClicked() {
    this.onAddBtnClick.emit(this.openAsModal);
  }

}
