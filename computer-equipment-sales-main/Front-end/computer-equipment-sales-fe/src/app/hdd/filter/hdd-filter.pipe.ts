import { Pipe, PipeTransform } from '@angular/core';
import {Hdd} from '../../model/hdd/hdd';

@Pipe({
  name: 'hddFilter'
})
export class HddFilterPipe implements PipeTransform {

  transform(value: Hdd[], filterText?: string): Hdd[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Hdd) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
