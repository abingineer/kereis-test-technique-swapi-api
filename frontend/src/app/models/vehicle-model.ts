import {Starship} from './starship-model';

export interface Vehicle extends Starship{
  vehicleClass: string;
}
