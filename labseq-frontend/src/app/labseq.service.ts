import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LabseqService {
  private apiUrl = 'http://localhost:8080/labseq'; // URL do seu serviço REST

  constructor(private http: HttpClient) {
  }

  getLabSeq(n: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/${n}`);
  }
}
