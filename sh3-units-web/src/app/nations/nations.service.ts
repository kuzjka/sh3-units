import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { OrderOfBattle, UnitSelectionEntry } from "./nations.model";
import { NationEntry } from "../core/data.model";
import { Injectable } from "@angular/core";

@Injectable()
export class NationsService {

  constructor(private http: HttpClient) {}

  getMerchantSelection(): Observable<UnitSelectionEntry[]> {
    return this.http.get<UnitSelectionEntry[]>('/api/merchantSelection');
  }

  getWarshipSelection(): Observable<UnitSelectionEntry[]> {
    return this.http.get<UnitSelectionEntry[]>('/api/warshipSelection');
  }

  getUboatSelection(): Observable<UnitSelectionEntry[]> {
    return this.http.get<UnitSelectionEntry[]>('/api/uboatSelection');
  }

  getAircraftSelection(): Observable<UnitSelectionEntry[]> {
    return this.http.get<UnitSelectionEntry[]>('/api/aircraftSelection');
  }

  addNation(name: string, image: ArrayBuffer) {
    const body = {
      unit: name,
      image: this.encode(image)
    };

    return this.http.post<null>('/api/nation', body);
  }

  saveOrderOfBattle(order: OrderOfBattle) {
    return this.http.put<null>('/api/order', order);
  }

  private encode(buffer: ArrayBuffer) {
    return btoa(
      new Uint8Array(buffer).reduce((data, byte) => data + String.fromCharCode(byte), '')
    );
  }
}
