import { Pipe, PipeTransform } from '@angular/core';
import {Mainboard} from '../../model/mainboard/mainboard';

@Pipe({
  name: 'mainboardFilter'
})
export class MainboardFilterPipe implements PipeTransform {

  transform(value: Mainboard[], filterText?: string): Mainboard[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Mainboard) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
