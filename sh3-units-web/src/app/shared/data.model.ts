export interface Merchant {
  name: string,
  displacement: number,
  length: number,
  beam: number,
  draft: number,
  mast: number,
  speed: number,
  category: MerchantCategory
}

export interface Warship {
  name: string,
  displacement: number,
  length: number,
  beam: number,
  draft: number,
  mast: number,
  speed: number,
  category: WarshipCategory,
  deckGun: boolean,
  aaGun: boolean,
  torpedoes: boolean,
  depthCharges: boolean
}

export interface UBoat {
  name: string,
  displacementSurfaced: number,
  displacementSubmerged: number,
  speedSurfaced: number,
  speedSubmerged: number,
  divingDepth: number,
  bowTubes: number,
  sternTubes: number
}

export interface Aircraft {
  name: string,
  speed: number,
  range: number,
  length: number,
  wingspan: number,
  ordnance: string,
  bombs: boolean,
  depthCharges: boolean,
  rockets: boolean,
  torpedoes: boolean,
  pakGun: boolean,
  leighLight: boolean,
  sirene: boolean
}

export interface UnitEntry<T> {
  unit: T,
  imageUrl: string,
  thumbUrl: string
}

export interface NationEntry {
  nation: string,
  flagUrl: string
}

export interface UnitSelectionEntry {
  id: number,
  name: string,
  thumbUrl: string
}

export enum MerchantCategory {
  Merchant = 'MERCHANT',
  Passenger = 'PASSENGER',
  Tanker = 'TANKER',
  Small = 'SMALL',
  Sailing = 'SAILING',
  Replenishment = 'REPLENISHMENT',
  Troop = 'TROOP',
  Other = 'OTHER'
}

export enum WarshipCategory {
  Battleship = 'BATTLESHIP',
  Carrier = 'CARRIER',
  Cruiser = 'CRUISER',
  Destroyer = 'DESTROYER',
  Frigate = 'FRIGATE',
  Corvette = 'CORVETTE',
  Replenishment = 'REPLENISHMENT',
  Troop = 'TROOP',
  Auxiliaries = 'AUXILIARIES',
  Other = 'OTHER'
}
