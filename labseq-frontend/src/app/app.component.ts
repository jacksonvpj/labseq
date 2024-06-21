import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {LabseqService} from "./labseq.service";
import {FormsModule} from "@angular/forms";
import {JsonPipe, NgIf} from "@angular/common";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, NgIf, JsonPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'labseq';
  n: number = 0;
  result: number | undefined;

  constructor(private labseqService: LabseqService) {
  }

  getLabSeq(): void {
    this.labseqService.getLabSeq(this.n).subscribe(result => {
      this.result = result;
    }, error => {
      this.result = error.error;
    });
  }
}
