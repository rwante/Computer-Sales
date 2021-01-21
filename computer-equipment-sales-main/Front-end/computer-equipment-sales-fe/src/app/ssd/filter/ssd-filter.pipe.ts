import { Pipe, PipeTransform } from '@angular/core';
import {Ssd} from '../../model/ssd/ssd';

@Pipe({
  name: 'ssdFilter'
})
export class SsdFilterPipe implements PipeTransform {

  transform(value: Ssd[], filterText?: string): Ssd[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Ssd) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
