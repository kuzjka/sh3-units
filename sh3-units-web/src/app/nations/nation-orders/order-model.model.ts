import { Presence, UnitSelectionEntry } from "../nations.model";

export class OrderModel {
  merchants: OrderModelEntry[] = [];
  warships: OrderModelEntry[] = [];
  uboats: OrderModelEntry[] = [];
  aircraft: OrderModelEntry[] = [];

  addMerchant(unit: UnitSelectionEntry) {
    this.merchants.push(new OrderModelEntry(unit));
  }

  addWarship(unit: UnitSelectionEntry) {
    this.warships.push(new OrderModelEntry(unit))
  }

  addUboat(unit: UnitSelectionEntry) {
    this.uboats.push(new OrderModelEntry(unit));
  }

  addAircraft(unit: UnitSelectionEntry) {
    this.aircraft.push(new OrderModelEntry(unit));
  }

  getMerchantPresences(): Presence[] {
    return this.getPresences(this.merchants);
  }

  getWarshipPresences(): Presence[] {
    return this.getPresences(this.warships);
  }

  getUboatPresences(): Presence[] {
    return this.getPresences(this.uboats);
  }

  getAircraftPresences(): Presence[] {
    return this.getPresences(this.aircraft);
  }

  private getPresences(arr: OrderModelEntry[]): Presence[] {
    return arr.map(e => ({
      unitId: e.unit.id,
      start: e.start,
      end: e.end
    }));
  }
}

export class OrderModelEntry {
  unit: UnitSelectionEntry;
  start: number;
  end: number;

  constructor(unit: UnitSelectionEntry) {
    this.unit = unit;
    this.start = 1939;
    this.end = 1945;
  }
}
