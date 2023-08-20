export interface UnitSelectionEntry {
  id: number,
  name: string,
  thumbUrl: string
}

export interface Presence {
  unitId: number;
  start: number;
  end: number
}

export interface OrderOfBattle {
  nationId: number;
  merchants: Presence[];
  warships: Presence[];
  uboats: Presence[];
  aircraft: Presence[];
}
