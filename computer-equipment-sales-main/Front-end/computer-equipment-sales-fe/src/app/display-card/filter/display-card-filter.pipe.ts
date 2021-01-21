import { Pipe, PipeTransform } from '@angular/core';
import {DisplayCard} from '../../model/display-card/display-card';

@Pipe({
  name: 'displayCardFilter'
})
export class DisplayCardFilterPipe implements PipeTransform {

  transform(value: DisplayCard[], filterText?: string): DisplayCard[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: DisplayCard) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
