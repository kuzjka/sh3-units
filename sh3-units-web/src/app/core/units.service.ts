import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Aircraft, Merchant, NationEntry, UBoat, UnitEntry, Warship } from "./data.model";

@Injectable()
export class UnitsService {

  constructor(private http: HttpClient) { }

  isEditable(): Observable<boolean> {
    return this.http.get<boolean>('/api/editable');
  }

  getMerchants(year?: number, nations?: string[]) {
    let params = new HttpParams();
    if (year) params = params.set('year', year);
    if (nations) params = params.appendAll({nations: nations});

    return this.http.get<UnitEntry<Merchant>[]>('/api/merchants', { params });
  }

  getWarships(year?: number, nations?: string[]) {
    let params = new HttpParams();
    if (year) params = params.set('year', year);
    if (nations) params = params.appendAll({ nations: nations });

    return this.http.get<UnitEntry<Warship>[]>('/api/warships', { params });
  }

  getUboats(year?: number, nations?: string[]) {
    let params = new HttpParams();
    if (year) params = params.set('year', year);
    if (nations) params = params.appendAll({ nations: nations });

    return this.http.get<UnitEntry<UBoat>[]>('/api/uboats', { params });
  }

  getAircraft(year?: number, nations?: string[]) {
    let params = new HttpParams();
    if (year) params = params.set('year', year);
    if (nations) params = params.appendAll({ nations: nations });

    return this.http.get<UnitEntry<Aircraft>[]>('/api/aircraft', { params });
  }

  getNations(): Observable<NationEntry[]> {
    return this.http.get<NationEntry[]>('/api/nations');
  }

  addMerchant(merchant: Merchant, image: ArrayBuffer) {
    let body = {
      unit: merchant,
      image: this.encode(image)
    };

    return this.http.post('/api/merchant', body);
  }

  addWarship(warship: Warship, image: ArrayBuffer) {
    let body = {
      unit: warship,
      image: this.encode(image)
    };

    return this.http.post('/api/warship', body);
  }

  addUBoat(uboat: UBoat, image: ArrayBuffer) {
    let body = {
      unit: uboat,
      image: this.encode(image)
    };

    return this.http.post('/api/uboat', body);
  }

  addAircraft(aircraft: Aircraft, image: ArrayBuffer) {
    let body = {
      unit: aircraft,
      image: this.encode(image)
    };

    return this.http.post('/api/aircraft', body);
  }

  private encode(buffer: ArrayBuffer) {
    return btoa(
      new Uint8Array(buffer).reduce((data, byte) => data + String.fromCharCode(byte), '')
    );
  }
}
